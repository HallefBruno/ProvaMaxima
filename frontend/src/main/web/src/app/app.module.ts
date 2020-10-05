import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PessoaComponent } from './pessoa/pessoa.component';
import { HttpClientModule } from '@angular/common/http';
import { ProdutoComponent } from './produto/produto.component';
import { CurrencyMaskInputMode, NgxCurrencyModule } from 'ngx-currency';
import { NovoPedidoComponent } from './novo-pedido/novo-pedido.component';
import {AutocompleteLibModule} from 'angular-ng-autocomplete';

export const customCurrencyMaskConfig = {
	align: "left",
	allowNegative: true,
	allowZero: true,
	decimal: ",",
	precision: 2,
	prefix: "R$ ",
	suffix: "",
	thousands: ".",
	nullable: true,
	min: null,
	max: null,
	inputMode: CurrencyMaskInputMode.FINANCIAL
};

@NgModule({
	declarations: [
		AppComponent,
		PessoaComponent,
		ProdutoComponent,
		NovoPedidoComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		FormsModule,
		HttpClientModule,
		FormsModule,
		ReactiveFormsModule,
		AutocompleteLibModule,
		NgxCurrencyModule.forRoot(customCurrencyMaskConfig)
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
