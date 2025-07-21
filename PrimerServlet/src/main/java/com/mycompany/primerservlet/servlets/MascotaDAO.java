package com.mycompany.primerservlet.servlets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    // 🔽 Crear una nueva mascota
    public boolean insertarMascota(Mascota m) {
        String sql = "INSERT INTO historial_medico_mascota (nombre_mascota, id_mascota, id_propietario, edad, especie, raza, sexo, fecha, nombre_procedimiento, fecha_procedimiento, responsable_procedimiento, nombre_medicamento, dosis, frecuencia) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getNombreMascota());
            ps.setString(2, m.getIdMascota());
            ps.setString(3, m.getIdPropietario());
            ps.setInt(4, m.getEdad());
            ps.setString(5, m.getEspecie());
            ps.setString(6, m.getRaza());
            ps.setString(7, m.getSexo());
            ps.setDate(8, new java.sql.Date(m.getFecha().getTime()));
            ps.setString(9, m.getNombreProcedimiento());
            ps.setDate(10, new java.sql.Date(m.getFechaProcedimiento().getTime()));
            ps.setString(11, m.getResponsableProcedimiento());
            ps.setString(12, m.getNombreMedicamento());
            ps.setString(13, m.getDosis());
            ps.setString(14, m.getFrecuencia());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar mascota: " + e.getMessage());
            return false;
        }
    }

    // 🔽 Consultar todas las mascotas
    public List<Mascota> obtenerMascotas() {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM historial_medico_mascota";

        try (Connection con = ConexionBD.obtenerConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mascota m = new Mascota();
                m.setId(rs.getInt("id"));
                m.setNombreMascota(rs.getString("nombre_mascota"));
                m.setIdMascota(rs.getString("id_mascota"));
                m.setIdPropietario(rs.getString("id_propietario"));
                m.setEdad(rs.getInt("edad"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setSexo(rs.getString("sexo"));
                m.setFecha(rs.getDate("fecha"));
                m.setNombreProcedimiento(rs.getString("nombre_procedimiento"));
                m.setFechaProcedimiento(rs.getDate("fecha_procedimiento"));
                m.setResponsableProcedimiento(rs.getString("responsable_procedimiento"));
                m.setNombreMedicamento(rs.getString("nombre_medicamento"));
                m.setDosis(rs.getString("dosis"));
                m.setFrecuencia(rs.getString("frecuencia"));
                lista.add(m);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar mascotas: " + e.getMessage());
        }

        return lista;
    }

    // 🔽 Eliminar por ID
    public boolean eliminarMascota(int id) {
        String sql = "DELETE FROM historial_medico_mascota WHERE id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar mascota: " + e.getMessage());
            return false;
        }
    }

    // 🔽 Actualizar mascota
    public boolean actualizarMascota(Mascota m) {
        String sql = "UPDATE historial_medico_mascota SET nombre_mascota=?, id_mascota=?, id_propietario=?, edad=?, especie=?, raza=?, sexo=?, fecha=?, nombre_procedimiento=?, fecha_procedimiento=?, responsable_procedimiento=?, nombre_medicamento=?, dosis=?, frecuencia=? WHERE id=?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getNombreMascota());
            ps.setString(2, m.getIdMascota());
            ps.setString(3, m.getIdPropietario());
            ps.setInt(4, m.getEdad());
            ps.setString(5, m.getEspecie());
            ps.setString(6, m.getRaza());
            ps.setString(7, m.getSexo());
            ps.setDate(8, new java.sql.Date(m.getFecha().getTime()));
            ps.setString(9, m.getNombreProcedimiento());
            ps.setDate(10, new java.sql.Date(m.getFechaProcedimiento().getTime()));
            ps.setString(11, m.getResponsableProcedimiento());
            ps.setString(12, m.getNombreMedicamento());
            ps.setString(13, m.getDosis());
            ps.setString(14, m.getFrecuencia());
            ps.setInt(15, m.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar mascota: " + e.getMessage());
            return false;
        }
    }

    // 🔽 Obtener una mascota por ID (para editar)
    public Mascota obtenerMascotaPorId(int id) {
        Mascota mascota = null;
        String sql = "SELECT * FROM historial_medico_mascota WHERE id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    mascota = new Mascota();
                    mascota.setId(rs.getInt("id"));
                    mascota.setNombreMascota(rs.getString("nombre_mascota"));
                    mascota.setIdMascota(rs.getString("id_mascota"));
                    mascota.setIdPropietario(rs.getString("id_propietario"));
                    mascota.setEdad(rs.getInt("edad"));
                    mascota.setEspecie(rs.getString("especie"));
                    mascota.setRaza(rs.getString("raza"));
                    mascota.setSexo(rs.getString("sexo"));
                    mascota.setFecha(rs.getDate("fecha"));
                    mascota.setNombreProcedimiento(rs.getString("nombre_procedimiento"));
                    mascota.setFechaProcedimiento(rs.getDate("fecha_procedimiento"));
                    mascota.setResponsableProcedimiento(rs.getString("responsable_procedimiento"));
                    mascota.setNombreMedicamento(rs.getString("nombre_medicamento"));
                    mascota.setDosis(rs.getString("dosis"));
                    mascota.setFrecuencia(rs.getString("frecuencia"));
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al obtener mascota por ID: " + e.getMessage());
        }

        return mascota;
    }
}