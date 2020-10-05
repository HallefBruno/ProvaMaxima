import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class NovoPedidoService {

	private baseUrl = 'http://localhost:8081/ecommerce/pedidos';

    constructor(private http: HttpClient) { }

    salvar(produto: Object): Observable<Object> {
        return this.http.post(`${this.baseUrl}/salvar`, produto);
	}
	
	getClientes(nome: any): Observable<any> {
        let params = new HttpParams().set('nome', nome)
        return this.http.get(`${this.baseUrl}/clientes/nome`, {params: params});
    }

}
