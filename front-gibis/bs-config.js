module.exports = {
    server: {
      middleware: {
        // overrides the second middleware default with new settings
        1: require('connect-history-api-fallback')({
          baseDir: "./src",
           index: './src/components/pages/crudGibi/FormUpdateGibi.js',
          
          verbose: true,
        }),
      },
    },
  };