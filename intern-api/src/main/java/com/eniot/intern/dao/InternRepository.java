package com.eniot.intern.dao;

import com.eniot.intern.lib.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>Note: I'm using Spring Data JPA here so alot of persistence related methods is automatically created</p>
 * <br/>
 *
 * <p>
 * If you are familiar with convential JPA, you con do still do that too...
 * <br/>
 * Eg:
 * <pre>{@code
 * @RequiredArgsConstructor
 * public class InternRepositoryImpl extends SomeInterface{
 *
 * @PersistenceContext
 * private final EntityManager em;
 *
 * //Implement methods from interface here
 * }
 * }</pre>
 * </code>
 * </p>
 */
public interface InternRepository extends JpaRepository<Intern, Long> {
  List<Intern> findPersonByNameEqualsIgnoreCase(String name);
  List<Intern> findPersonBySchoolEqualsIgnoreCase(String school);
  List<Intern> findPersonByNameEqualsIgnoreCaseOrSchoolEqualsIgnoreCase(String name, String school);
}