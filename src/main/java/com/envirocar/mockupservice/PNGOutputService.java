package com.envirocar.mockupservice;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/track")
public class PNGOutputService {
	@GET
	@Path("/preview")
	@Produces("image/png")
	public Response getMsg() {
		ByteArrayOutputStream byteArrayOS = null;
		try {			
			InputStream in = this.getClass().getClassLoader()
					.getResourceAsStream("endjourney.png");
			BufferedImage image = ImageIO.read(in);
			byteArrayOS = new ByteArrayOutputStream();
			ImageIO.write(image, "png", byteArrayOS);

		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] imageData = byteArrayOS.toByteArray();
		return Response.ok(imageData).build();
	}
}
