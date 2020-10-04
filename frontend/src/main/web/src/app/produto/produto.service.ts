import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class ProdutoService {

	private baseUrl = 'http://localhost:8081/ecommerce/produtos';

    constructor(private http: HttpClient) { }

    salvar(produto: Object): Observable<Object> {
        return this.http.post(`${this.baseUrl}/salvar`, produto);
    }
}
