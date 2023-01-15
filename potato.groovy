@groovy.transform.InheritConstructors
class Tank {
	int facets = 16;
	double length = 300;
	double diameter = 150;
	double cyllen = length-diameter;
	def toCSG(){
		CSG sphere = new Sphere(diameter,facets,8).toCSG().rotx(90);
		CSG body = new Cylinder(	diameter, // Radius at the top
		diameter, // Radius at the bottom
		cyllen, // Height
		(int)facets //resolution
		).toCSG();
		body = body.union([sphere,sphere.movez(cyllen)]);
		body = body.movez(-cyllen/2)
		body = body.rotz(22.5);
		
		return body;
	}
}

return new Tank().toCSG();
