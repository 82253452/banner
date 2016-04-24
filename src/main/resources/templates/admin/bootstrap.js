// atscript without runtime-type assertions.
System.traceurOptions = {
  annotations: true,
  memberVariables: true,
  typeAssertions: false,
  types: true
};
System.config({
  transpiler: 'typescript',
  typescriptOptions: {
    emitDecoratorMetadata: true
  },
  baseURL: '/templates/',
  map: {
    'angular2':'node_modules/angular2',
    'ng2bootstrap':'node_modules/ng2-bootstrap',
    'jquery': 'admin/lib',
    'rxjs' : 'node_modules/rxjs',
    'typescript' : 'node_modules/typescript/lib/typescript.js',
    'app': 'admin',
    'components': 'admin/components',
    'common': 'admin/common',
    'service': 'admin/service',
    'moment':'node_modules/moment/moment.js'
  },
  packages: {
    rxjs:{
      defaultExtension: 'js'
    },
    ng2bootstrap:{
      defaultExtension: 'js'
    },
    jquery:{
      defaultExtension:'js'
    },
    components:{
      defaultExtension: 'ts'
    },
    common:{
      defaultExtension: 'ts'
    },
    service:{
      defaultExtension: 'ts'
    },
    app:{
      defaultExtension: 'js'
    },
    angular2: {
      defaultExtension: 'js'
    },
    moment:{
      defaultExtension: 'js'
    }
  }
});

System.import('./app.js')
    .catch(console.error.bind(console));