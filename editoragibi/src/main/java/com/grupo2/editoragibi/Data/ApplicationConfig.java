package com.grupo2.editoragibi.Data;

import com.grupo2.editoragibi.Data.Entity.GibiEntity;import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
    @Bean
    public IGibiRepository iGibiRepository() {
      return new IGibiRepository() {
          @Override
          public List<GibiEntity> findAll() {
              return null;
          }

          @Override
          public List<GibiEntity> findAll(Sort sort) {
              return null;
          }

          @Override
          public List<GibiEntity> findAllById(Iterable<Integer> integers) {
              return null;
          }

          @Override
          public <S extends GibiEntity> List<S> saveAll(Iterable<S> entities) {
              return null;
          }

          @Override
          public void flush() {

          }

          @Override
          public <S extends GibiEntity> S saveAndFlush(S entity) {
              return null;
          }

          @Override
          public <S extends GibiEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
              return null;
          }

          @Override
          public void deleteAllInBatch(Iterable<GibiEntity> entities) {

          }

          @Override
          public void deleteAllByIdInBatch(Iterable<Integer> integers) {

          }

          @Override
          public void deleteAllInBatch() {

          }

          @Override
          public GibiEntity getOne(Integer integer) {
              return null;
          }

          @Override
          public GibiEntity getById(Integer integer) {
              return null;
          }

          @Override
          public <S extends GibiEntity> List<S> findAll(Example<S> example) {
              return null;
          }

          @Override
          public <S extends GibiEntity> List<S> findAll(Example<S> example, Sort sort) {
              return null;
          }

          @Override
          public Page<GibiEntity> findAll(Pageable pageable) {
              return null;
          }

          @Override
          public <S extends GibiEntity> S save(S entity) {
              return null;
          }

          @Override
          public Optional<GibiEntity> findById(Integer integer) {
              return Optional.empty();
          }

          @Override
          public boolean existsById(Integer integer) {
              return false;
          }

          @Override
          public long count() {
              return 0;
          }

          @Override
          public void deleteById(Integer integer) {

          }

          @Override
          public void delete(GibiEntity entity) {

          }

          @Override
          public void deleteAllById(Iterable<? extends Integer> integers) {

          }

          @Override
          public void deleteAll(Iterable<? extends GibiEntity> entities) {

          }

          @Override
          public void deleteAll() {

          }

          @Override
          public <S extends GibiEntity> Optional<S> findOne(Example<S> example) {
              return Optional.empty();
          }

          @Override
          public <S extends GibiEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
              return null;
          }

          @Override
          public <S extends GibiEntity> long count(Example<S> example) {
              return 0;
          }

          @Override
          public <S extends GibiEntity> boolean exists(Example<S> example) {
              return false;
          }

          @Override
          public <S extends GibiEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
              return null;
          }
      };
    }
}