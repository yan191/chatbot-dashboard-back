package br.com.fatec.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.dashboard.security.User;
import br.com.fatec.dashboard.service.UserService;

@RestController
public class AcessoController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity createNewUser(@RequestBody User usuario){
		try {			
			userService.save(usuario);
		}catch(Exception e) {
			return new ResponseEntity<>("Não foi possivel cadastrar o usuário.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Usuário cadastrado com sucesso.", HttpStatus.OK);
	}
	
	@GetMapping("/user/:username")
	public ResponseEntity getUserByUsername(@RequestParam("username") String username){
		User user;
		try {
			user = userService.getByUsername(username);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Não foi possivel recuperar informações do usuário.");
		}
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/teste")
	public ResponseEntity<String> getTeste(){
		return ResponseEntity.ok().body("Teste bem sucedido.");
	}

}
