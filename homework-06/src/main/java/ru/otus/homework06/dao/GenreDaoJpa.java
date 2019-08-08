package ru.otus.homework06.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.otus.homework06.dao.mappers.GenreMapper;
import ru.otus.homework06.domain.Book;
import ru.otus.homework06.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("ConstantConditions")
@Repository
@Transactional
@AllArgsConstructor
public class GenreDaoJpa implements GenreDao {

    @PersistenceContext
    private EntityManager em;

    private final NamedParameterJdbcOperations jdbcOperations;
    private final GenreMapper genreMapper;

    @Override
    public int count() {
//        return jdbcOperations.queryForObject("select count(*) from genres", new EmptySqlParameterSource(), Integer.class);
        return em.createQuery("select count(g) from Genre g", Long.class)
                .getSingleResult() .intValue();
    }

    @Override
    public Genre getById(int id) {
        return em.find(Genre.class, id);

//        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
//        return jdbcOperations.queryForObject("select * from genres where id = :id", parameterSource, genreMapper);
    }

    @Override
    public Genre getByGenre(String genre) {
//        SqlParameterSource parameterSource = new MapSqlParameterSource("genre", genre);
//        return jdbcOperations.queryForObject("select * from genres where genre = :genre", parameterSource, genreMapper);
        return em.createQuery("select g from Genre g where g.genre = :genre", Genre.class)
                .setParameter("genre", genre)
                .getSingleResult();
    }

    @Override
    public Genre getByBook(Book book) {
//        SqlParameterSource parameterSource = new MapSqlParameterSource("id", book.getId());
//        return jdbcOperations.queryForObject("select * from genres g where g.id in (select genre_id from books b where b.id = :id)", parameterSource, genreMapper);
        return em.createQuery("select g from Genre g where g.id = :id", Genre.class)
                .setParameter("id", book.getGenre().getId())
                .getSingleResult();
    }

    @Override
    public List<Genre> getAll() {
//        return jdbcOperations.query("select * from genres", new EmptySqlParameterSource(), genreMapper);
    return em.createQuery("select g from Genre g", Genre.class).getResultList();
    }

    @Override
    public void insert(Genre genre) {
//        SqlParameterSource parameterSource = new MapSqlParameterSource("genre", genre.getGenre());
//        return jdbcOperations.update("insert into genres values(default, :genre)", parameterSource);
        em.persist(genre);
    }

    @Override
    public int deleteById(int id) {
//        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
//        return jdbcOperations.update("delete from genres where id = :id", parameterSource);
        Genre genre = em.find(Genre.class, id);
        em.remove(genre);
        return 1;
    }

}
