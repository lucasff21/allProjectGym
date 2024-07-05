package com.combo.allProject.service;

import com.combo.allProject.dto.AlunoDTO;
import com.combo.allProject.model.Aluno;
import com.combo.allProject.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;


import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements  UserDetailsService{
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Aluno alunoGet = alunoRepository.findByEmail(email);

        if(alunoGet == null){
            throw  new  UsernameNotFoundException ( "Usuário não encontrado" );
        }

        return alunoGet;
    }
    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno update(Integer id, Aluno aluno){
       Optional<Aluno> alunoOptional = alunoRepository.findById(id);
       if(alunoOptional.isPresent()){
           return alunoRepository.save(aluno);
       } else {
           throw new EntityNotFoundException("Aluno not found with ID: " + aluno.getId());

       }
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public Aluno getById(Integer id){
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if(alunoOptional.isPresent()){
            return alunoOptional.get();
        }

        throw new ResourceNotFoundException("Aluno não encontrada.");

    }

    public void delete(Aluno aluno){
        alunoRepository.delete(aluno);
    }

    public Aluno registerUser(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setPassword(passwordEncoder.encode(alunoDTO.getPassword()));
        return alunoRepository.save(aluno);
    }
}
