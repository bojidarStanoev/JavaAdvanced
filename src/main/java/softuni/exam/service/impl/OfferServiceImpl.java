package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferSeedRootDto;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private static final String PATH_OF_OFFER = "src/main/resources/files/xml/offers.xml";

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count()>0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_OFFER));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        OfferSeedRootDto offerSeedRootDto = xmlParser.fromFile(PATH_OF_OFFER,OfferSeedRootDto.class);
        offerSeedRootDto.getOffers().stream().forEach(offerSeedDtp -> {
            boolean isValid = validationUtil.isValid(offerSeedDtp);
            if(agentRepository.findByFirstName(offerSeedDtp.getAgent().getName()).isEmpty()){
               isValid=false;
            }
            sb.append(isValid?String.format("Successfully imported offer %.2f",offerSeedDtp.getPrice()):"Invalid offer").append(System.lineSeparator());
            if(isValid){
            Offer offer=modelMapper.map(offerSeedDtp,Offer.class);
            offer.setAgent(agentRepository.findByFirstName(offerSeedDtp.getAgent().getName()).get());
            offer.setApartment(apartmentRepository.getById(offerSeedDtp.getApartment().getId()));


                offerRepository.save(offer);
            }

        });
        return sb.toString();
    }

    @Override
    public String exportOffers() {
        StringBuilder sb= new StringBuilder();
        List<Offer> res = offerRepository.findOfferByAgent_FirstNameAndAgent_LastNameAndApartment();
        res.forEach(offer -> {

            sb.append(String.format("Agent %s %s with offer №%d:\n" +
                    "   \t\t-Apartment area: %.2f\n" +
                    "   \t\t--Town: %s\n" +
                    "   \t\t---Price: %.2f$\n",offer.getAgent().getFirstName(),offer.getAgent().getLastName(),offer.getId(),offer.getApartment().getArea(),offer.getApartment().getTown().getTownName(), offer.getPrice()));
        });
        return sb.toString();
    }
}
