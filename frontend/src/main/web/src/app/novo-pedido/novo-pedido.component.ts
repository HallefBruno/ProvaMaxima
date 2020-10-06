import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import { NovoPedidoService } from './novo-pedido.service';
import { HttpClient } from '@angular/common/http';


@Component({
	selector: 'app-novo-pedido',
	templateUrl: './novo-pedido.component.html',
	styleUrls: ['./novo-pedido.component.css']
})
export class NovoPedidoComponent implements OnInit {

	@ViewChild('boxinputPrecoUnitario') inputPrecoUnitario: ElementRef;

	form: FormGroup;
	submitted = false;
	salvando = true;
	isLoadingResult: boolean;
	results: string[];
	urlImage: string;
	listProdutos: any[] = [];
	precoAtual:string="";

	constructor(private fb: FormBuilder, private router: Router, private novoPedidoService: NovoPedidoService) { }

	ngOnInit(): void {

		this.form = this.fb.group({
			nomeCliente: [undefined, Validators.required],
			nomeProduto: [undefined, Validators.required],
			quantidade: [undefined, Validators.required]
		});

	}

	searchCliente(event: any) {
		this.novoPedidoService.getClientes(event.query).subscribe(data => {
			this.results = data;
		});
	}

	onSelect(event: any) {
		console.log(event);
		this.listProdutos.push(event);
	}

	searchProduto(event: any) {
		this.novoPedidoService.getProdutos(event.query).subscribe(data => {
			//this.form.get('quantidade').setValue("");
			this.results = data;
		});
	}

	onKey(event: any) {
		console.log(event);
		console.log(this.form.get('quantidade').value);
	}


}