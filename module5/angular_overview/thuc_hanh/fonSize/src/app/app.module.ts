import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FontSizeEditorComponent} from './font-size-editor/font-size-editor.component';
import {PetComponent} from './pet/pet.component';
import {AwesomeCalculatorComponent} from './awesome-calculator/awesome-calculator.component';
import {ColorPickerComponent} from './color-picker/color-picker.component';
import {HackernewsComponent} from './hackernews/hackernews.component';
import {FormsModule} from '@angular/forms';
import {LikesComponent} from './likes/likes.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {CreateComponent} from './create/create.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    AwesomeCalculatorComponent,
    ColorPickerComponent,
    HackernewsComponent,
    LikesComponent,
    HeaderComponent,
    FooterComponent,
    CreateComponent,
    NameCardComponent,
    ProgressBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
