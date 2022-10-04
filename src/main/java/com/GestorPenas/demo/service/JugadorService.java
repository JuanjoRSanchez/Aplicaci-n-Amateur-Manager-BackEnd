package com.GestorPenas.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestorPenas.demo.DTO.AddJugadorDTO;
import com.GestorPenas.demo.Model.Jugador;
import com.GestorPenas.demo.Model.Pena;
import com.GestorPenas.demo.repositories.JugadorRepository;
import com.GestorPenas.demo.repositories.PenaRepository;

@Service
public class JugadorService {

    @Autowired
    private final JugadorRepository jugadorRepository;

    @Autowired
    private final PenaRepository penaRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository, PenaRepository penaRepository) {
        this.jugadorRepository = jugadorRepository;
        this.penaRepository = penaRepository;
    }

    public Jugador getJugadorById(int id) {
        Long idPenaLong = (long) id;
        Jugador jugador = new Jugador();
        Optional<Jugador> jugadorAux = jugadorRepository.findById(idPenaLong);
        if (jugadorAux.isPresent()) {
            jugador = jugadorAux.get();
        }
        return jugador;
    }

    public List<Jugador> getJugadoresByIdPena(int id) {
        List<Jugador> jugadores = new ArrayList<Jugador>();
        Long idPenaLong = (long) id;
        Optional<Pena> pena = penaRepository.findById(idPenaLong);
        if (pena.isPresent()) {
            jugadores = jugadorRepository.findByPena(pena.get());
        }

        return jugadores;
    }

    public List<Jugador> getJugadoresByPena() {
        return jugadorRepository.findAll();
    }

    public int setJugador(AddJugadorDTO addJugadorDTO) {
        int salida = 0;
        Long idPena = (long) addJugadorDTO.getIdPena() ;
        Jugador jugador = new Jugador();

        Optional<Pena> penaAux = penaRepository.findById(idPena);

        if (penaAux.isPresent()) {
            jugador.setDireccion(addJugadorDTO.getDireccion());
            jugador.setEdad(addJugadorDTO.getEdad());
            jugador.setNombre(addJugadorDTO.getNombre());
            jugador.setPass(addJugadorDTO.getPass());
            jugador.setTelefono(addJugadorDTO.getTelefono());
            jugador.setPena(penaAux.get());
            jugadorRepository.save(jugador);
            salida = 1;
        }
        return salida;
    }

    public int updateJugador(AddJugadorDTO addJugadorDTO) {
        int salida = 0;
        Long idJugador = (long) Integer.parseInt(addJugadorDTO.getIdJugador()) ;
        Jugador jugador = new Jugador();
        Optional<Jugador> jugadoraux = jugadorRepository.findById(idJugador);

        if (jugadoraux.isPresent()) {
            if(addJugadorDTO.getTelefono() != null){
                jugadoraux.get().setTelefono(addJugadorDTO.getTelefono());
            }else if (addJugadorDTO.getEdad() != null){
                jugadoraux.get().setEdad(addJugadorDTO.getEdad());
            } else if (addJugadorDTO.getNombre() != null) {
                jugadoraux.get().setNombre(addJugadorDTO.getNombre());
            } else if (addJugadorDTO.getDireccion() != null) {
                jugadoraux.get().setDireccion(addJugadorDTO.getDireccion());
            } else if (addJugadorDTO.getPass() != null) {
                jugadoraux.get().setPass(addJugadorDTO.getPass());
            }
            jugadorRepository.save(jugadoraux.get());
            salida = 1;
        }
        /*
        if (jugadoraux.isPresent()) {
            if(addJugadorDTO.getTelefono() != null){
                jugador.setTelefono(addJugadorDTO.getTelefono());
            }else if (addJugadorDTO.getEdad() != null){
                jugador.setEdad(addJugadorDTO.getEdad());
            } else if (addJugadorDTO.getNombre() != null) {
                jugador.setNombre(addJugadorDTO.getNombre());
            } else if (addJugadorDTO.getDireccion() != null) {
                jugador.setDireccion(addJugadorDTO.getDireccion());
            } else if (addJugadorDTO.getPass() != null) {
                jugador.setPass(addJugadorDTO.getPass());
            }
            jugadorRepository.save(jugador);
            salida = 1;
        }
        */

        return salida;
    }
}
