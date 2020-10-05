import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { NovoPedidoComponent } from './novo-pedido/novo-pedido.component';
import { PessoaComponent } from './pessoa/pessoa.component';
import { ProdutoComponent } from './produto/produto.component';

const routes: Routes = [
    { path: 'pessoas', component: PessoaComponent },
    { path: 'produtos', component: ProdutoComponent },
    { path: 'novo-pedido', component: NovoPedidoComponent }
];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
export class AppRoutingModule {}