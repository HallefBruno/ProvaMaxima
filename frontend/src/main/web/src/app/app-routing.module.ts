import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PessoaComponent } from './pessoa/pessoa.component';
import { ProdutoComponent } from './produto/produto.component';

const routes: Routes = [

    { path: 'pessoas', component: PessoaComponent },
    { path: 'produtos', component: ProdutoComponent }
];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
export class AppRoutingModule {}