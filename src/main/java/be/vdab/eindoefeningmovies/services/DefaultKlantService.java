package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.domain.Klant;
import be.vdab.eindoefeningmovies.repositories.KlantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
class DefaultKlantService implements KlantService{
    private final KlantRepository klantRepository;

    DefaultKlantService(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Klant> findByBevatLetters(String letters) {
        return klantRepository.findByBevatLetters(letters);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Klant> findById(long id) {
        return klantRepository.findById(id);
    }
}
