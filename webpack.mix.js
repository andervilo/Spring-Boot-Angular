const mix = require('laravel-mix');

/*
 |--------------------------------------------------------------------------
 | Mix Asset Management
 |--------------------------------------------------------------------------
 |
 | Mix provides a clean, fluent API for defining some Webpack build steps
 | for your Laravel application. By default, we are compiling the Sass
 | file for the application as well as bundling up all the JS files.
 |
 */

mix.js('resources/main.js', 'src/main/resources/static/js')
	.sass('resources/sass/app.scss', 'src/main/resources/static/css')
	.copyDirectory('resources/assets', 'src/main/resources/static/images')
.copyDirectory('fonts', 'src/main/resources/static/fonts')
.copyDirectory('images', 'src/main/resources/static/images');
