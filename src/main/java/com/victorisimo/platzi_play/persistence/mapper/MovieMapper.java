package com.victorisimo.platzi_play.persistence.mapper;

import com.victorisimo.platzi_play.domain.dto.MovieDto;
import com.victorisimo.platzi_play.persistence.entity.MovieEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, StatusMapper.class })
public interface MovieMapper {

    @Mapping(source = "title", target = "title")
    @Mapping(source = "timeMinutes", target = "timeMinutes")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "stringToGenre")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "status", target = "status", qualifiedByName = "stringToStatus")
    MovieDto toDto(MovieEntity movieEntity);
    List<MovieDto> toDto(Iterable<MovieEntity> movieEntities);

    @InheritConfiguration
    @Mapping(source = "gender", target = "gender", qualifiedByName = "genreToString")
    @Mapping(source = "status", target = "status", qualifiedByName = "statusToString")
    MovieEntity toEntity(MovieDto movieDto);
}
