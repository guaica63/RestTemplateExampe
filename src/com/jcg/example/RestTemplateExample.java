package com.jcg.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jcg.example.bean.Actor;

public class RestTemplateExample
{
	public static void main(String[] args)
	{
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/allActors";

		// Captura la Lista desde el servicio WEB
		ResponseEntity<List<Actor>> response = restTemplate.exchange(
				url,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Actor>>(){});
		List<Actor> actores = response.getBody();

		System.out.println(actores);

		actores.forEach(act -> System.out.println(act));
		
		System.out.println("After Sorting the student data by Age:"); 
		
		// Aplicacion de SORT sobre la lista con JAVA 8 no Stream
		
		System.out.println("Aplicando SORT");
		actores.sort(Comparator.comparing(Actor::getId).thenComparing(Actor::getAvatar_url).reversed());
		actores.forEach(act -> System.out.println("Sort: " + act));
		
		// Aplicacion de SORT sobre la lista con JAVA 8 Stream
		System.out.println("Aplicando SORTED");
		actores.stream().sorted((a1, a2) -> a1.getLogin().compareTo(a2.getLogin()))
		.forEach(act ->  System.out.println("Sorted: " + act));
		
		
	// POST con RESTTEMPLATE. Creacion de un Actor (POST)
		String urlCrea = "http://localhost:8080/actors";
		Long indice = (long) 400;
		Actor newActor = new Actor(indice, "AdamLogin", "Avatar_Adam");
		 
	    Actor result = restTemplate.postForObject( urlCrea, newActor, Actor.class);
	 
	    System.out.println("Resultado de la creacion RESTTEMPLATE: " + result);
		

	}
}
