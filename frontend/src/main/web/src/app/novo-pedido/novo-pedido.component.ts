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

	ele:ElementRef
	form: FormGroup;
	submitted = false;
	salvando = true;
	isLoadingResult: boolean;
	clientes: any[];
	produtos:any[];
	itensPedido:any[]=[];
	urlImage: string;
	listProdutos: any[] = [];
	precoAtual:number;
	urlImagem:string;

	constructor(private fb: FormBuilder, private router: Router, private novoPedidoService: NovoPedidoService) { 
	}

	ngOnInit(): void {

		this.form = this.fb.group({
			nomeCliente: ['', Validators.required],
			nomeProduto: ['', Validators.required],
			quantidade: ['', Validators.required]
		});

	}

	searchCliente(cliente: any) {
		this.novoPedidoService.getClientes(cliente.query).subscribe(data => {
			this.clientes = data;
		});
	}

	searchProduto(produto: any) {
		this.novoPedidoService.getProdutos(produto.query).subscribe(data => {
			this.produtos = data;
		});
	}

	onSelect(produto: any) {
		if(this.containsObject(produto,this.listProdutos)) {
			this.listProdutos.push(produto);
			if(produto.imagemUrl===null) {
				produto.imagemUrl = 'assets/icones/abra-a-caixa-de-papelao.png';
			}
		}
	}

	focusout(teste: any) {
		//console.log(teste);
		//let quantidade = this.form.get('quantidade').value;
		//let valor = produto.precoUnitario * quantidade;
		//document.getElementById(produto.id+"-precoAtual").setAttribute('value',"R$ "+valor.toString());
		
	}

	getQuantidade(quantidade:any) {
		//console.log(quantidade);
	}

	containsObject(obj:any, list:any) {
		if(list.length == 0) {
			return true;
		}
		for (let i = 0; i < list.length; i++) {
			if (list[i].nome === obj.nome) {
				return false;
			}
		}
		return true;
	}

	incluir(produto:any) {
		let quantidade = (<HTMLInputElement>document.getElementsByName(produto.id+"-quantidade")[0]).value;
		if(quantidade!==null && quantidade!=="") {
			this.itensPedido.push({'idProduto':produto.id,'quantidade':Number(quantidade)});
		} else {
			alert('Preencha a quantidade!');
		}
	}
	remove(produto:any) {

		if(this.itensPedido.length > 0) {
			for(let i=0; i<this.itensPedido.length; i++) {
				if(this.itensPedido[i].idProduto === produto.id) {
					this.itensPedido.splice(i,1);
					this.listProdutos.splice(i,1);
					this.form.get('nomeCliente').reset();
					this.form.get('nomeProduto').reset();
				}
			}
		} else {
			alert('Nenhum item a ser removido!');
		}
	}

	onSubmit(petsForm:any) {

		this.submitted = true;
        this.salvando = false;
        if (this.form.valid) {
			let pedido = {
				cliente: {
					'id':this.clientes[0].id
				}
			};

			console.log(pedido);

			this.novoPedidoService.salvar(pedido).subscribe(response=>{
				console.log(response);
			}, error => {
				console.log(error);
			});

			console.log(this.itensPedido,pedido);
		}
		this.submitted = false;
        this.salvando = true;
	}

}