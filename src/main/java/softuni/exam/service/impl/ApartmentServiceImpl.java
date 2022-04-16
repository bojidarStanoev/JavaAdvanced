package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentSeedRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;
    private final static String  PATH_OF_APART = "src/main/resources/files/xml/apartments.xml";

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, TownRepository townRepository) {
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count()>0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(PATH_OF_APART));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
       StringBuilder sb = new StringBuilder();
        ApartmentSeedRootDto apartmentSeedRootDto = xmlParser.fromFile(PATH_OF_APART, ApartmentSeedRootDto.class);
            apartmentSeedRootDto.getApartment().stream().forEach(apartmentSeedDto -> {
                boolean isValid = validationUtil.isValid(apartmentSeedDto);
                if(apartmentRepository.getApartmentByTownTownNameAndArea(apartmentSeedDto.getTown(),apartmentSeedDto.getArea()).isPresent()){
                    isValid=false;
                }
                sb.append(isValid?String.format("Successfully imported apartment %s - %.2f",apartmentSeedDto.getApartmentType(),apartmentSeedDto.getArea()):"Invalid apartment").append(System.lineSeparator());
                Apartment apartment = modelMapper.map(apartmentSeedDto,Apartment.class);
                apartment.setTown(townRepository.getTownByTownName(apartmentSeedDto.getTown()));
                if(isValid){
                    apartmentRepository.save(apartment);
                }

            });
        return sb.toString();
    }
}
