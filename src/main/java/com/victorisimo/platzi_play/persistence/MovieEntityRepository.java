package com.victorisimo.platzi_play.persistence;

import com.victorisimo.platzi_play.domain.dto.MovieDto;
import com.victorisimo.platzi_play.domain.repository.MovieRepository;
import com.victorisimo.platzi_play.persistence.crud.CrudMovieEntity;
import com.victorisimo.platzi_play.persistence.entity.MovieEntity;
import com.victorisimo.platzi_play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper mapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = mapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }
    @Override
    public MovieDto getById(long id) {
        return this.movieMapper.toDto(this.crudMovieEntity.findById(id).orElse(null));
    }
}
