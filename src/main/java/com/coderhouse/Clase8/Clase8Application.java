package com.coderhouse.Clase8;
import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.repository.ClienteRepository;
import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Optional;

@SpringBootApplication
public class Clase8Application implements CommandLineRunner {
/*Agrego Autowired para delegar la instanciacion de objetos al Farameworw
 Uno la interface con la base*/

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Clase8Application.class, args);
	}


	//Metodo Run  para correr mis sentencias Java
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Acceda al Server desde aqui..http://localhost:8888/h2-console/login.jsp?");

// Creo un nuevo PRODUCTO pava
		Producto mate = new Producto();
		mate.setCodigo("jiiiiiiiiii");
		mate.setDescripcion("Mate de calabazin");
		mate.setPrecio_producto(1.5);
		mate.setStock(10);
		this.productoRepository.save(mate);

		Producto tetera = new Producto();
		tetera.setCodigo("agfdkdiiiiii");
		tetera.setDescripcion("Tetera de acero");
		tetera.setPrecio_producto(2.4);
		tetera.setStock(5);
		this.productoRepository.save(tetera);

		Optional<Producto> productoObtenido = this.productoRepository.findById(2);
		if (productoObtenido.isPresent()) System.out.println(productoObtenido.get());
		else System.out.println("Producto no encontrado ...");

//Creo CLIENTES nuevos
		Cliente zonaSur = new Cliente();
		zonaSur.setApellido("Rodriguez");
		zonaSur.setNombre("Casa la Estrella");
		zonaSur.setDocumento(21123123);
		this.clienteRepository.save(zonaSur);

		Cliente zonaNorte = new Cliente();
		zonaNorte.setApellido("Robaina");
		zonaNorte.setNombre("Casa Fanny");
		zonaNorte.setDocumento(21121123);
		this.clienteRepository.save(zonaNorte);

		Cliente zonaOeste = new Cliente();
		zonaOeste.setApellido("Suarez");
		zonaOeste.setNombre("Papu Repuestos ");
		zonaOeste.setDocumento(33121123);
		this.clienteRepository.save(zonaOeste);


		/*busquedas personalizadas
		List<Cliente> clientes = this.clienteRepository.findByNombreLike("%Casa%");
		System.out.println(clientes.size());
		PrintClientes(clientes);

		List<Cliente> clientes = this.clienteRepository.findByApellidoLike("%Ro%");
		System.out.println(clientes.size());
		printClientes(clientes);+/

		// Funcion que recorre la lista de cliente y lo imprime
		/*	static void printClientes(List<Cliente> ListadoClientes) {
		for (Cliente cliente : ListadoClientes) {
			System.out.println(cliente);
		}*/
		//}

		// Funcion que recorre la lista de Facturas y lo imprime
	   /*	static void printFacturas(List<Factura> ListadoFacturas) {
		for (Factura factura : ListadoFacturas) {
			System.out.println(factura);
		}*/

	}
}