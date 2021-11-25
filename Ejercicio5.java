import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Ejercicio5 {

  public static void main(String[] args) {
    List<Alumno> alumnos = List.of(
        new Alumno("Homero", "Simpson", LocalDate.of(1956, 05, 12)),
        new Alumno("Bart", "Simpson", LocalDate.of(1990, 09, 10)),
        new Alumno("Lisa", "Simpson", LocalDate.of(1992, 10, 1)),
        new Alumno("Marge", "Simpson", LocalDate.of(1960, 2, 11)),
        new Alumno("Maggie", "Simpson", LocalDate.of(2000, 2, 29)));
    Map<String, Integer> edades = new HashMap<>();

    for (Alumno alumno : alumnos) {
      edades.put(alumno.getApellido() + " " + alumno.getNombre(),
          alumno.getNacimiento().until(LocalDate.now()).getYears());
    }
    System.out.println(edades);
  }
}

public class Alumno {
  private final String nombre;
  private final String apellido;
  private final LocalDate nacimiento;

  public Alumno(String nombre, String apellido, LocalDate nacimiento) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.nacimiento = nacimiento;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public LocalDate getNacimiento() {
    return nacimiento;
  }

  @Override
  public String toString() {
    return "Alumno{"
        + "nombre='"
        + nombre
        + '\''
        + ", apellido='"
        + apellido
        + '\''
        + ", nacimiento="
        + nacimiento
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Alumno alumno = (Alumno) o;
    return Objects.equals(nombre, alumno.nombre)
        && Objects.equals(apellido, alumno.apellido)
        && Objects.equals(nacimiento, alumno.nacimiento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, apellido, nacimiento);
  }
}