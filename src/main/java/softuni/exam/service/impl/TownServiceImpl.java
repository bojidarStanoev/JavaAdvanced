package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final static String PATH_OF_TOWN = "src/main/resources/files/json/towns.json";

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return townRepository.count()>0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(PATH_OF_TOWN));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder sb = new StringBuilder();
        TownSeedDto [] townSeedDtos =gson.fromJson(readTownsFileContent(),TownSeedDto [].class);
        Arrays.stream(townSeedDtos).filter(townSeedDto -> {
            boolean isValid=validationUtil.isValid(townSeedDto);
            sb.append(isValid?String.format("Successfully imported town %s - %d",townSeedDto.getTownName(),townSeedDto.getPopulation()):"Invalid Town").append(System.lineSeparator());
            return isValid;
        }).map(townSeedDto -> modelMapper.map(townSeedDto, Town.class)).forEach(townRepository::save);
        return sb.toString();
    }

    @Override
    public Town getByName(String name) {
        return townRepository.getTownByTownName(name);}
}
