import Image from "next/image";
import githubIcon from "../public/social.png";
import prIcon from "../public/pull-request.png";
import editIcon from "../public/edit.png";
import Link from "next/link";

export default function Footer() {
  const WIDTH_HEIGHT = 20;
  return (
    <div className="footer d-flex justify-content-evenly align-items-center border-top mt-3">
      <div>
        <Link
          className="d-flex align-items-center"
          href={"https://github.com/tanhaok/docs/pulls"}
          target="_blank"
        >
          <div className="m-1">
            <Image
              src={prIcon}
              alt="Contribute"
              width={WIDTH_HEIGHT}
              height={WIDTH_HEIGHT}
            ></Image>
          </div>
          <div className="h5"> Contribute</div>
        </Link>
      </div>
      <div>
        <div>
          <Image
            src={githubIcon}
            alt="Contribute"
            width={WIDTH_HEIGHT * 3}
            height={WIDTH_HEIGHT * 3}
          ></Image>
        </div>
      </div>
      <div>
        <Link
          className="d-flex align-items-center"
          href={"https://github.com/tanhaok/docs"}
          target="_blank"
        >
          <div className="m-1">
            <Image
              src={editIcon}
              alt="Contribute"
              width={WIDTH_HEIGHT}
              height={WIDTH_HEIGHT}
            ></Image>
          </div>
          <div className="h5">Edit this page</div>
        </Link>
      </div>
    </div>
  );
}
