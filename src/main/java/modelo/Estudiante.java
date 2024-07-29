
package modelo;


public class Estudiante {
    //Atrbutos
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private double edad;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
    public Estudiante(int idEstudiante, String nombre, String apellido, String email, String telefono, double edad) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }

    public Estudiante(String nombre, String apellido, String email, String telefono, double edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }
    
}
