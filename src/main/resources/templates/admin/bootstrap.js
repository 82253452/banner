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
    'rxjs' : 'node_modules/rxjs',
    'typescript' : 'node_modules/typescript/lib/typescript.js',
    'app': 'admin',
    'components': 'admin/components',
    'common': 'admin/common',
    'service': 'admin/service'
  },
  packages: {
    rxjs:{
      defaultExtension: 'js'
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
    }
  }
});

System.import('./app.js')
    .catch(console.error.bind(console));