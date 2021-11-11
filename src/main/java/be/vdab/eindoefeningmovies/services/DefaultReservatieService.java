package be.vdab.eindoefeningmovies.services;

import be.vdab.eindoefeningmovies.domain.Reservatie;
import be.vdab.eindoefeningmovies.repositories.FilmRepository;
import be.vdab.eindoefeningmovies.repositories.ReservatieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class DefaultReservatieService implements ReservatieService {
    private final ReservatieRepository reservatieRepository;
    private final FilmRepository filmRepository;

    DefaultReservatieService(ReservatieRepository reservatieRepository, FilmRepository filmRepository) {
        this.reservatieRepository = reservatieRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    @Transactional
    //straks hier update bij in verwerken
    public void updateAndCreate(Reservatie reservatie) {
        reservatieRepository.create(reservatie);
        filmRepository.update(reservatie.getFilmId());

    }

}
