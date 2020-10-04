import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import { ProdutoService } from './produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

    form: FormGroup;
    submitted = false;
    salvando = true;
    
    constructor(private fb: FormBuilder, private router: Router, private produtoService:ProdutoService) { }

    ngOnInit() {
        this.form = this.fb.group({
			nome: ['', Validators.required],
			preco: ['', Validators.required]
        });
	}
	
	onSubmit() {

		console.log(this.form.get('preco').value);

        this.submitted = true;
        this.salvando = false;
        if (this.form.valid) {
            let produto = { 
				'nome': this.form.get('nome').value,
				'precoUnitario': this.form.get('preco').value,
				'imagemUrl':null
			};
            this.produtoService.salvar(produto).subscribe(data => {
                console.log(data)
                this.submitted = false;
                this.salvando = true;
                this.messageSucces('Registro salvo com sucesso!');
            }, error => {
                this.submitted = false;
                this.salvando = true;
                console.log(error);
                if(error && error.error) {
                    Swal.fire({
                        icon: 'warning',
                        title: error.error.messageUser
                    });
                }
            });
        }
    }
    messageSucces(message:string) {
        const Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 5000,
            timerProgressBar: true,
            didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer)
                toast.addEventListener('mouseleave', Swal.resumeTimer)
            }
        });

        Toast.fire({
            icon: 'success',
            title: `${message}`
        });
    }

}
