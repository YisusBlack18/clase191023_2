import java.util.List;
import java.util.ArrayList;

interface LibroRepository {
    void guardarLibro(Libro libro);
    Libro obtenerLibroPorISBN(int isbn);
    List<Libro> listarLibros();
    void eliminarLibro(int isbn);
}

class Libro {
    private int isbn;
    private String titulo;
    private String autor;

    public Libro(int isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters, Setters y toString

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}

class LibroRepositoryImpl implements LibroRepository {
    private List<Libro> libros;

    public LibroRepositoryImpl() {
        this.libros = new ArrayList<>();
    }

    @Override
    public void guardarLibro(Libro libro) {
        libros.add(libro);
    }

    @Override
    public Libro obtenerLibroPorISBN(int isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public List<Libro> listarLibros() {
        return libros;
    }

    @Override
    public void eliminarLibro(int isbn) {
        libros.removeIf(libro -> libro.getIsbn() == isbn);
    }
}

public class Libreria {
    public static void main(String[] args) throws Exception {
        LibroRepository libroRepository = new LibroRepositoryImpl();

        Libro libro1 = new Libro(12345, "Cien años de soledad", "Gabriel Garcia Marquez");
        Libro libro2 = new Libro(67890, "El principito", "Antoine de Saint-Exupéry");

        libroRepository.guardarLibro(libro1);
        libroRepository.guardarLibro(libro2);

        System.out.println(libroRepository.listarLibros());

        libroRepository.eliminarLibro(67890);

        System.out.println(libroRepository.listarLibros());
    }
}
