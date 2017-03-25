<template>
<div>
 
  <div id="canvas-frame"></div>
</div>
</template>

<script>
let renderer,stats,camera,light,scene,cube,mesh,group,width,height;
export default {
  name: 'threeBox',
  data() {
    return {

    };
  },
 components: {

 },
  methods: {
    initThree(){
                width = $(window).width()
                height = $(window).height()/2;
                renderer = new THREE.WebGLRenderer({
                    antialias : true
                });
                renderer.setSize(width, height);
                document.getElementById('canvas-frame').appendChild(renderer.domElement);
                renderer.setClearColor(0xFFFFFF, 1.0);

             
                
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
       light = new THREE.AmbientLight(0xFF0000);
       light.position.set(100, 100, 200);
       scene.add(light);
    },
    initObject(){

                var geometry = new THREE.BoxGeometry( 100, 100, 100 );

                for ( var i = 0; i < geometry.faces.length; i += 2 ) {

                    var hex = Math.random() * 0xffffff;
                    geometry.faces[ i ].color.setHex( hex );
                    geometry.faces[ i + 1 ].color.setHex( hex );

                }

        var material = new THREE.MeshBasicMaterial( { vertexColors: THREE.FaceColors} );
        mesh = new THREE.Mesh( geometry,material);
        // mesh.position = new THREE.Vector3(0,0,0);
        mesh.position.set(0, 0, 0);

        // 组对象，其实派生于Object3D
                group = new THREE.Group(); // new THREE.Object3D();
                group.add(mesh);

                mesh.translateX(-50);
                //mesh.translateY(-50);
                mesh.translateZ(50);

                group.translateX(50);
                //group.translateY(50);
                group.translateZ(-50);

        scene.add(group);

    },
    initGrid(){
      var helper = new THREE.GridHelper( 1000, 50 );
                helper.setColors( 0x0000ff, 0x808080 );
                scene.add( helper );
    },
    animation(){
      group.rotation.y -=0.01;
      renderer.render(scene, camera);
      requestAnimationFrame(this.animation);
    },
    threeStart(){
      this.initThree();
      this.initCamera();
      this.initScene();
      this.initLight();
      this.initObject();
      this.initGrid();
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

