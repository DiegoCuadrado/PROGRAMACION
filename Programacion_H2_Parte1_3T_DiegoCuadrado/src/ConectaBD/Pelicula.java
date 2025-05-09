package ConectaBD;

public class Pelicula {
    public String codigo, titulo, director, genero, idSala;
    public int duracion;

    public Pelicula(String codigo, String titulo, String director, String genero, int duracion, String idSala) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.idSala = idSala;
    }
}



