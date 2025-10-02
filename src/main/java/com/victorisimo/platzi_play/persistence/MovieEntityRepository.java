package com.victorisimo.platzi_play.persistence;

import com.victorisimo.platzi_play.domain.dto.MovieDto;
import com.victorisimo.platzi_play.domain.dto.UpdateMovieDto;
import com.victorisimo.platzi_play.domain.exception.MovieAlreadyExistsException;
import com.victorisimo.platzi_play.domain.repository.MovieRepository;
import com.victorisimo.platzi_play.persistence.crud.CrudMovieEntity;
import com.victorisimo.platzi_play.persistence.entity.MovieEntity;
import com.victorisimo.platzi_play.persistence.mapper.MovieMapper;
import com.victorisimo.platzi_play.web.exception.MovieModifiedDontExist;
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

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (this.crudMovieEntity.findByTitle(movieDto.title() ) != null) {
            throw new MovieAlreadyExistsException(movieDto.title());
        }
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        if(movieEntity != null) {
            this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);
            return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
        }else{
            throw new MovieModifiedDontExist(id);
        }
    }

    @Override
    public Boolean delete(long id) {
        if(this.crudMovieEntity.existsById(id)){
            this.crudMovieEntity.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
