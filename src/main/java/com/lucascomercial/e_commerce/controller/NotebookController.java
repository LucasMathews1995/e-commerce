package com.lucascomercial.e_commerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lucascomercial.e_commerce.DTO.NotebookDTO;
import com.lucascomercial.e_commerce.exceptions.NotebookRequireParamsException;
import com.lucascomercial.e_commerce.exceptions.NotEnoughStock;
import com.lucascomercial.e_commerce.model.product.Notebook;
import com.lucascomercial.e_commerce.service.NotebookService;

@RestController
@RequestMapping("/api/eletronics/notebook")
public class NotebookController {

@Autowired 
private NotebookService service;

    @GetMapping()
    public ResponseEntity<List<Notebook>> listarNotebooks(){
        try{
            List<Notebook> notebooks = service.listarNotebook();
            return ResponseEntity.ok().body(notebooks);
        }catch(NotEnoughStock e ){
            return ResponseEntity.notFound().build();
        }
    }

@PostMapping("/saveAll")
    public ResponseEntity<String> saveAllNoteBook(@RequestBody List<NotebookDTO> notebookDTOs){
 try{
        String message = service.addAllNoteBook(notebookDTOs);
        return ResponseEntity.ok().body(message);
    }catch(NotebookRequireParamsException e){
      
        return ResponseEntity.badRequest().build();
    }

    }

@PostMapping("/save")
public ResponseEntity<Notebook> saveNotebook(@RequestBody NotebookDTO notebookDTO){
    try{
        Notebook notebook = service.addNotebook(notebookDTO);
        return ResponseEntity.ok().body(notebook);
    }catch(NotebookRequireParamsException e){
      
        return ResponseEntity.badRequest().build();
    }
}
    
}
