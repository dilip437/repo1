import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { SharedServiceParentModule } from './app/poc.sharedserv.module';
import { environment } from './environments/environment';

if (environment.production) {
    enableProdMode();
}

platformBrowserDynamic().bootstrapModule(SharedServiceParentModule)
    .catch(err => console.error(err));
