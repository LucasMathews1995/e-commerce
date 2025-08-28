package com.lucascomercial.e_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucascomercial.e_commerce.DTO.NotebookDTO;
import com.lucascomercial.e_commerce.exceptions.BrandNotFoundException;
import com.lucascomercial.e_commerce.model.Brand;
import com.lucascomercial.e_commerce.model.product.Notebook;
import com.lucascomercial.e_commerce.repository.BrandRepository;
import com.lucascomercial.e_commerce.repository.NotebookRepository;

@Service
public class NotebookService {


    @Autowired
    private NotebookRepository repository;

@Autowired
private BrandRepository brandRepository;

    public List<Notebook> listarNotebook(){


        List<Notebook> notebooks = repository.findAll();

        if(!notebooks.isEmpty()){
            return notebooks;
        }else {
            return null;}
    }

    
    public Notebook  addNotebook(NotebookDTO notebook){
      
        Notebook notebook2 = new Notebook(notebook.name(),notebook.price(),notebook.stock(),notebook.discount(),notebook.model(),notebook.voltage(),notebook.warrantyPeriod(),notebook.storageCapacity(),notebook.screenSize(),notebook.operatingSystem(),notebook.color(),notebook.weight());
    
          Brand brand = brandRepository.findByName(notebook.brandname()).orElse(new Brand(notebook.brandname(),null));

        notebook2.setBrand(brand);

        repository.save(notebook2);
        return notebook2;

    }
    public String addAllNoteBook(List<NotebookDTO> notebookDTO){

        List<Notebook> notebooks = notebookDTO.stream().map((it)->new Notebook(it.name(),it.price(),it.stock(),it.discount(),
        it.model(),it.voltage(),it.warrantyPeriod(),it.storageCapacity(),it.screenSize(),it.operatingSystem(),it.color(),it.weight())).toList();

      for(int i=0 ; i<= notebooks.size();i++){

     Brand brand =    brandRepository.findByName(notebookDTO.get(i).brandname()).orElse(new Brand(notebookDTO.get(i).brandname(),null));
        notebooks.get(i).setBrand(brand);
        brandRepository.save(brand);
        repository.save(notebooks.get(i));
      }
       
        
        return "Todos os itens salvos";
    }


    
}
