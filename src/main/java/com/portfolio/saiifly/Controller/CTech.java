package com.portfolio.saiifly.Controller;

import com.portfolio.saiifly.Dto.dtoTech;
import com.portfolio.saiifly.Entity.tech;
import com.portfolio.saiifly.Security.Controller.Mensaje;
import com.portfolio.saiifly.Service.Stech;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-frontentd.web.app")
@RequestMapping("/technologies")
public class CTech {

    @Autowired
    Stech sTech;

    @GetMapping("/lista")
    public ResponseEntity<List<tech>> list() {
        List<tech> list = sTech.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<tech> getById(@PathVariable("id") int id) {
        if (!sTech.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        tech tEch = sTech.getOne(id).get();
        return new ResponseEntity(tEch, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sTech.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sTech.delete(id);
        return new ResponseEntity(new Mensaje("Tecnologia borrada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoTech dtoTech) {
        if (StringUtils.isBlank(dtoTech.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sTech.existsByNombre(dtoTech.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa tecnologia ya existe"), HttpStatus.BAD_REQUEST);
        }

        tech tEch = new tech(dtoTech.getNombre(), dtoTech.getImgLink());
        sTech.save(tEch);

        return new ResponseEntity(new Mensaje("Tecnologia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTech dtoTech) {
        //Validamos si existe el ID
        if (!sTech.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sTech.existsByNombre(dtoTech.getNombre()) && sTech.getByNombre(dtoTech.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa tecnologia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoTech.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        tech tEch = sTech.getOne(id).get();
        tEch.setNombre(dtoTech.getNombre());
        tEch.setImgLink(dtoTech.getImgLink());

        sTech.save(tEch);
        return new ResponseEntity(new Mensaje("Tecnologia actualizada"), HttpStatus.OK);

    }
}
