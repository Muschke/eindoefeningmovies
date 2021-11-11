package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.domain.Klant;
import be.vdab.eindoefeningmovies.repositories.KlantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return null;
    }
}
