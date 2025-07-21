package com.mycompany.primerservlet.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/veterinariadb";
    private static final String USUARIO = "root"; // cambia si usas otro usuario
    private static final String CONTRASENA = "Tati9@2004";  // cambia si tienes contraseña

    public static Connection obtenerConexion() {
        Connection conexion = null;

        try {
            // Registrar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Obtener la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: Driver de MySQL no encontrado");
            e.printStackTrace();

        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos");
            e.printStackTrace();
        }

        return conexion;
    }
}

