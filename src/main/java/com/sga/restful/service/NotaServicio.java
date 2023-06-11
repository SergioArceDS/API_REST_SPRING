package com.sga.restful.service;

import com.sga.restful.converter.Convertidor;
import com.sga.restful.entity.Nota;
import com.sga.restful.model.MNota;
import com.sga.restful.repository.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicio")
public class NotaServicio {
    @Autowired
    @Qualifier("repositorio")
    private NotaRepositorio repositorio;

    @Autowired
    @Qualifier("convertidor")
    private Convertidor convertidor;

    public boolean crear(Nota nota){
        try{
            repositorio.save(nota);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean actualizar(Nota nota){
        try{
            repositorio.save(nota);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean borrar(String nombre, long id){
        try{
            Nota nota = repositorio.findByNombreAndId(nombre, id);
            repositorio.delete(nota);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public List<MNota> obtener (){
        return  convertidor.convertirLista(repositorio.findAll());
    }

    public MNota obtenerPorNombreTitulo(String nombre, String titulo){
        return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
    }

    public List<MNota> obtenerPorTitulos (String titulo){
        return  convertidor.convertirLista(repositorio.findByTitulo(titulo));
    }
}
