package com.leoholmer.AllMusic.Backend.config;

import com.leoholmer.AllMusic.Backend.dto.SongResponseDTO;
import com.leoholmer.AllMusic.Backend.model.Song;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configurar mapeo personalizado entre Song y SongResponseDTO
        TypeMap<Song, SongResponseDTO> typeMap = modelMapper.createTypeMap(Song.class, SongResponseDTO.class);
        typeMap.addMappings(mapper -> {
            mapper.map(Song::getTitle, SongResponseDTO::setName);
            mapper.map(song -> song.getGenre().toString(), SongResponseDTO::setGenre);
        });

        return modelMapper;
    }
}