package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final static String PATH_OF_AGENT="src/main/resources/files/json/agents.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;
    private final TownService townService;
    public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, TownRepository townRepository, TownService townService) {
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count()>0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(PATH_OF_AGENT));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder sb = new StringBuilder();
        AgentSeedDto [] agentSeedDtos = gson.fromJson(readAgentsFromFile(),AgentSeedDto [].class);



        Arrays.stream(agentSeedDtos)
                .forEach(agentSeedDto -> {
            boolean isValid = validationUtil.isValid(agentSeedDto);
            if(agentRepository.findByFirstName(agentSeedDto.getFirstName()).isPresent()){
                isValid=false;
            }
            sb.append(isValid?String.format("Successfully imported agent - %s %s",agentSeedDto.getFirstName(),agentSeedDto.getLastName()):"Invalid agent")
                    .append(System.lineSeparator());
            Agent agent = modelMapper.map(agentSeedDto,Agent.class);
            agent.setTown(townService.getByName(agentSeedDto.getTown()));
            if(isValid)
            agentRepository.save(agent);
            });

        return sb.toString() ;
    }
}
