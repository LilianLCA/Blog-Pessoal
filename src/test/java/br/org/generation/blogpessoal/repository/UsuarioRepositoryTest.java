package br.org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.save(new Usuario(0L, "Lilian Assunção", "lilian@gmail.com.br", "123456789", "Sem foto"));
		
		usuarioRepository.save(new Usuario(0L, "Paloma Correa", "paloma@gmail.com.br", "987654321", "Sem foto"));
		
		usuarioRepository.save(new Usuario(0L, "Natalia Silva", "natalia@gmail.com.br", "888852340", "Sem foto"));
		
		usuarioRepository.save(new Usuario(0L, "Daiane Silva", "daiane@gmail.com.br", "888825430", "Sem foto"));
		
	}
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("paloma@gmail.com.br");
		assertTrue(usuario.get().getUsuario().equals("paloma@gmail.com.br"));
	}
	
	@Test
	@DisplayName("Retorna 2 usuarios")
	public void deveRetornarDoisUsuarios() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(2, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Natalia Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Daiane Silva"));
		
	}
}
