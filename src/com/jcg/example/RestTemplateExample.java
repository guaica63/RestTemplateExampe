package com.jcg.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
		actores.sort(Comparator.comparing(Actor::getLogin));
		// actores.sort(Comparator.comparing(Actor::getAvatar_url));
		actores.forEach(act -> System.out.println("Sort: " + act));

		// Aplicacion de SORT sobre la lista con JAVA 8 Stream
		System.out.println("Aplicand o SORTED");
		actores.stream().sorted((a1, a2) -> a1.getLogin().compareTo(a2.getLogin()));
		actores.forEach(act ->  System.out.println("Sorted: " + act));


		// POST con RESTTEMPLATE. Creacion de un Actor (POST)
		/*
		 * String urlCrea = "http://localhost:8080/actors"; Long indice = (long) 9681;
		 * // Actor newActor = new Actor(indice, "AdamLogin", "Avatar_Adam");
		 * 
		 * // Lanza con RestTemplate la creacion de registro. Actor act = new Actor();
		 * act.setId(indice); act.setLogin("Otro40"); act.setAvatar_url("avatarOtro40");
		 * Actor responseCrea = restTemplate.postForObject(urlCrea, act, Actor.class);
		 * System.out.println("Respuesta Creacion: " + responseCrea);
		 */


		// Buscar un solo registro
		String urlReadOne = "http://localhost:8080/unActor/{id}";
		Long indice = (long) 480;
		Map<String, Long> vars = Collections.singletonMap("id", indice);
		Actor act2 = restTemplate.getForObject("https://localhost:8080/unActor?id={id}", Actor.class, indice);
		System.out.println("El actor Leido es:" +  act2);


	}
}
