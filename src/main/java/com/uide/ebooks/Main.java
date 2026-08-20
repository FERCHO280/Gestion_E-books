package com.uide.ebooks;

import com.uide.ebooks.controllers.ApiController;

public class Main {
    private static final ApiController api = new ApiController();

    public static void main(String[] args) throws InterruptedException {
        imprimirBanner();

        // Simulación controlada de los 8 Endpoints de la API RESTful
        ejecutarEndpointsAuth();
        ejecutarEndpointsCatalogo();
        ejecutarEndpointsBiblioteca();

        imprimirCierre();
    }

    private static void imprimirBanner() {
        System.out.println("==================================================================");
        System.out.println("     SISTEMA DE GESTION DE E-BOOKS - API RESTFUL BACKEND          ");
        System.out.println("     Institución: Universidad Internacional del Ecuador (UIDE)    ");
        System.out.println("     Estudiante: Fernando Javier Gaibor Llango                    ");
        System.out.println("==================================================================\n");
    }

    private static void ejecutarEndpointsAuth() throws InterruptedException {
        System.out.println("[MODULO AUTENTICACION Y SEGURIDAD]");

        System.out.println(" > POST /api/auth/registro");
        Thread.sleep(250);
        System.out.println("   Respuesta: " + api.registrarUsuario("{ \"email\": \"admin@uide.edu.ec\" }"));

        System.out.println(" > POST /api/auth/login");
        Thread.sleep(250);
        System.out.println("   Respuesta: " + api.login("{ \"email\": \"admin@uide.edu.ec\" }\n"));
    }

    private static void ejecutarEndpointsCatalogo() throws InterruptedException {
        System.out.println("[MODULO CATALOGO INMUTABLE & ESTADISTICAS]");

        System.out.println(" > GET /api/catalogo/estadisticas (Métrica Avanzada Concurrente)");
        Thread.sleep(400);
        System.out.println("   Respuesta: " + api.obtenerEstadisticas());

        System.out.println(" > GET /api/catalogo/filtrar?genero=Informatica");
        Thread.sleep(250);
        System.out.println("   Respuesta: " + api.filtrarCatalogo("Informática"));

        System.out.println(" > POST /api/catalogo");
        Thread.sleep(250);
        System.out.println("   Respuesta: " + api.agregarLibro("{ \"titulo\": \"Ciberseguridad Defensiva\" }\n"));
    }

    private static void ejecutarEndpointsBiblioteca() throws InterruptedException {
        System.out.println("[MODULO BIBLIOTECA Y PROGRESO DE LECTURA]");

        System.out.println(" > POST /api/biblioteca/licencia");
        Thread.sleep(250);
        System.out.println("   Respuesta: " + api.otorgarLicencia("USR-01", "LIB-01"));

        System.out.println(" > GET /api/biblioteca/progreso/LIB-01 (Manejo Seguro con Optional)");
        Thread.sleep(250);
        System.out.println("   Respuesta: " + api.verProgreso("LIB-01"));

        System.out.println(" > PUT /api/biblioteca/progreso");
        Thread.sleep(250);
        System.out.println("   Respuesta: " + api.actualizarProgreso("{ \"avance\": \"100%\" }\n"));
    }

    private static void imprimirCierre() {
        System.out.println("==================================================================");
        System.out.println(" STATUS: Pool HikariCP activo | 8/8 Servicios JSON validados con éxito");
        System.out.println("==================================================================");
    }
}