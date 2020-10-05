import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import { NovoPedidoService } from './novo-pedido.service';

@Component({
	selector: 'app-novo-pedido',
	templateUrl: './novo-pedido.component.html',
	styleUrls: ['./novo-pedido.component.css']
})
export class NovoPedidoComponent implements OnInit {

	form: FormGroup;
    submitted = false;
    salvando = true;
	isLoadingResult: boolean;
	data:any[]=[];
	constructor(private fb: FormBuilder, private router: Router, private novoPedidoService:NovoPedidoService) { }
	
	ngOnInit(): void {

		this.form = this.fb.group({
            nomeCliente: [undefined, Validators.required]
        });

	}

	onChangeSearch(nome:string) {
		this.isLoadingResult = true;
		if(nome && nome.replace(/\s/g, "")) {
			this.novoPedidoService.getClientes(nome).subscribe(nomes=>{
				if(nomes) {
					console.log(nomes);
				}
			}, error => {
				console.log(error);	
			});
		}
		
	}

	searchCleared() {
    	console.log('searchCleared');
    	this.data = [];
  	}

}


//<ng-autocomplete [data]="data" 
//        [searchKeyword]="keyword" 
//       (selected)='selectEvent($event)'
//        (inputChanged)='onChangeSearch($event)' 
//        (inputFocused)='onFocused($event)' 
//        [itemTemplate]="itemTemplate"
//        [notFoundTemplate]="notFoundTemplate">
//    </ng-autocomplete>