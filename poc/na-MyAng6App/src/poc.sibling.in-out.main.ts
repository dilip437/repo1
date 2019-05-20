import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { SiblingInputOutputModule } from './app/poc.sibling.in-out.module';
import { environment } from './environments/environment';

if (environment.production) {
    enableProdMode();
}

platformBrowserDynamic().bootstrapModule(SiblingInputOutputModule)
    .catch(err => console.error(err));

