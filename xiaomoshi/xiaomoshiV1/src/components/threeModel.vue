<template>
<div>
 
  <div id="canvas-frame"></div>
</div>

</template>
<script>
let container,renderer,scene,camera;
let mouseX=0, mouseY=0;

			let windowHalfX = window.innerWidth / 2;
			let windowHalfY = window.innerHeight / 2;
      let width = $(window).width();
      let height = $(window).height()/2;
export default {
  name: 'threeModel',
  data() {
    return {
    };
  },
 components: {

 },
  methods: {
    initThree(){
                
                renderer = new THREE.WebGLRenderer({
                    antialias : true
                });
                	window.addEventListener( 'resize', this.onWindowResize, false );
                	renderer.setPixelRatio( window.devicePixelRatio );
                renderer.setSize(width, height);
                document.getElementById('canvas-frame').appendChild(renderer.domElement);
	// container.appendChild( rkenderer.domElement );
                	document.addEventListener( 'mousemove', this.onDocumentMouseMove, false );
         
    },
    initCamera(){
      camera = new THREE.PerspectiveCamera(45, width / height, 1, 10000);
                camera.position.x = 100;
                camera.position.y = 300;
                camera.position.z = 600;
                camera.up.x = 0;
                camera.up.y = 1;
                camera.up.z = 0;
                camera.lookAt({
                    x : 0,
                    y : 0,
                    z : 0
                });
    },
    initScene(){
                scene = new THREE.Scene();

    },
    initLight(){
     let directionalLight = new THREE.DirectionalLight( 0xffeedd );
				directionalLight.position.set( 0, 0, 1 );
				scene.add( directionalLight );
    },
    initObject(){
// texture
				var manager = new THREE.LoadingManager();
				manager.onProgress = function ( item, loaded, total ) {

					console.log( item, loaded, total );

				};

				var texture = new THREE.Texture();
				var texture2 = new THREE.Texture();

				var onProgress = function ( xhr ) {
					if ( xhr.lengthComputable ) {
						var percentComplete = xhr.loaded / xhr.total * 100;
						console.log( Math.round(percentComplete, 2) + '% downloaded' );
					}
				};

				var onError = function ( xhr ) {
				};
        var loader = new THREE.ImageLoader( manager );
				loader.load( '../../static/img/IMG_4327.JPG', function ( image ) {

					texture.image = image;
					texture.needsUpdate = true;

				} );
				loader.load( '../../static/img/IMG_4326.JPG', function ( image ) {

					texture2.image = image;
					texture2.needsUpdate = true;

				} );
  // model
        var i=0;
				var loader = new THREE.OBJLoader( manager );
				loader.load( '../../static/obj/male02.obj', function ( object ) {

					object.traverse( function ( child ) {

						if ( child instanceof THREE.Mesh ) {
							if(i % 2 == 0){
								child.material.map = texture2;
							}else{
								child.material.map = texture;
							}
							i++;
						}
					} );

					object.position.y = - 80;
					scene.add( object );

				}, onProgress, onError );
    },
onWindowResize() {
				windowHalfX = window.innerWidth / 2;
				windowHalfY = window.innerHeight / 2;
				camera.aspect = window.innerWidth / window.innerHeight;
				camera.updateProjectionMatrix();
				renderer.setSize( window.innerWidth, window.innerHeight );
			},
      onDocumentMouseMove(event) {
				mouseX = ( event.clientX - windowHalfX ) / 2;
				mouseY = ( event.clientY - windowHalfY ) / 2;
			},
    animation(){
      requestAnimationFrame(this.animation);
      this.render()
    },
    render() {
				camera.position.x += ( mouseX - camera.position.x ) * .05;
				camera.position.y += ( - mouseY - camera.position.y ) * .05;

				camera.lookAt( scene.position );

				renderer.render( scene, camera );

			},
    threeStart(){
      this.initThree();
      this.initCamera();
      this.initScene();
      this.initLight();
    //  this.onDocumentMouseMove();
      this.initObject();
      this.animation();
    }
  },
  watch: {

  },
  mounted () {
    this.threeStart();

  },
  filters: {
  }
};
</script>

