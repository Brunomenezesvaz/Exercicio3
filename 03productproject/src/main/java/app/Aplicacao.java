package app;
import static spark.Spark.*;
public class aplicacao {
	private static ProdutoService produtoService = new ProdutoService();
	
	public static void main(String[] args) {
		port(6789);
		
		post("/produto", (request, response) -> produtoService.add(request, response));
		get("/produto/:id", (request, response) -> produtoService.get(request, response));
		get("/produto/update/:id", (request, response) -> produtoService.update(request, response));
		get("/produto/delete/id", (request, response) -> produtoService.delete(request, response));
		get("/produto", (request, response) -> produtoService.getAll(request, response));
	}
}
