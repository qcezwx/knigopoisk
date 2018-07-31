import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule,
  MatCardModule,
  MatInputModule, MatMenuModule,
  MatProgressSpinnerModule,
  MatToolbarModule
} from "@angular/material";

@NgModule({
  imports: [
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatCardModule,
    MatMenuModule

  ],
  exports: [
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatCardModule,
    MatMenuModule
  ],
  declarations: []
})
export class MaterialModule { }
